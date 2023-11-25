package com.zaze.kotlin.example.test

import java.lang.StringBuilder
import java.util.LinkedList

fun main() {
    val itemA = "瓶子"
    val itemB = "唱片"
    val itemC = "项链"
    val items = listOf(
        Item(itemA, 6),
        Item(itemB, 4),
        Item(itemC, 2),
    )
    val shops = listOf<Shop>(
        Shop(
            name = "曼琳商店", items = items, prices = mapOf(
                itemA to 1150,
                itemB to 500,
                itemC to 170,
            )
        ),
        Shop(
            name = "卡米乐商店", items = items, prices = mapOf(
                itemA to 1085,
                itemB to 590,
                itemC to 220,
            )
        ),
        Shop(
            name = "小枫商店", items = items, prices = mapOf(
                itemA to 1490,
                itemB to 595,
                itemC to 225,
            )
        ),
        Shop(
            name = "海娜商店", items = items, prices = mapOf(
                itemA to 1385,
                itemB to 645,
                itemC to 175,
            )
        ),
    )

    var maxRole = Role(gold = 0, emptyList())
    shops.forEach { buy ->
        val role = Role(
            gold = 1200, packets = listOf(
                Packet(6),
                Packet(6)
            )
        )
        shops.forEach { sell ->
            if (buy.name != sell.name) {
                println("----------------------- start  -----------------------")
                val flows = ArrayList<String>()
                val ret = doIt(role, buy, sell, shops, flows)
                if (ret.gold > maxRole.gold) {
                    maxRole = ret
                }
//            println("ret: $ret")
                println("----------------------- end:${ret.gold} -----------------------")
            }
        }
    }
    // 海娜商店  卡米乐商店  小枫商店 曼琳商店
//    maxRole = doIt(
//        Role(
//            gold = 1200, packets = listOf(
//                Packet(6),
//                Packet(6)
//            )
//        ), shops.find {
//            it.name == "卡米乐商店"
//        }!!, shops.find {
//            it.name == "曼琳商店"
//        }!!, shops, ArrayList()
//    )
    println("最高金额: ${maxRole.gold}; 流水如下:")
    maxRole.printFlow()
}

fun doIt(role: Role, buy: Shop, sell: Shop, shops: List<Shop>, flowList: ArrayList<String>): Role {
    if (buy.name == sell.name) {
        return role
    }
    if (!buy.enable() || !sell.enable()) {
        if (buy.entryCount == 1 && sell.entryCount == 2) {
            // 看看是不是最后一个可用的商店
            var enableCount = 0
            shops.forEach {
                if (it.enable()) {
                    enableCount++
                }
            }
            if (enableCount == 1) {
                sell.sellAll(role)
                // 最后仅有一个商店所以没法交易，表示 完整的交易链结束
                role.flowList.clear()
                role.flowList.addAll(flowList)
                println("-- 最终金额: ${role.gold}")
//                role.printFlow()
//                println("-------------------------------------------------")
            }
        }
        return role
    }
    // 买
    val ret = buy.buy(role.gold, role.packets, sell)
    val remainGold = ret.gold
    val builder = StringBuilder()
    ret.packets.forEach {
        it.items.forEach { item ->
            val buyPrice = buy.getPrice(item)
            val sellPrice = sell.getPrice(item)
            builder.append("\n买了 ${item.id}(${buyPrice} > ${sellPrice}: ${sellPrice - buyPrice});")
        }
    }
    sell.sellAll(ret)
    val flow =
        "本金:${role.gold},去${buy.name}买,余:${remainGold}; 去${sell.name}卖,赚:${ret.gold - role.gold},结算:${ret.gold}; $builder\n"
    flowList.add(flow)
    var max = ret
    shops.forEach {
        val temp = doIt(ret, sell, it, shops, flowList)
        if (temp.gold > max.gold) {
            max = temp
        }
    }
    flowList.remove(flow)
    // 返回上层时，清除
    buy.reduceCount()
    return max
}

/**
 * 剩余金币
 * 剩余负重
 */
fun findBest(gold: Int, packages: List<Packet>, shops: List<Shop>): Int {
    var maxProfit = 0
    var buyShop: Shop? = null
    var sellShop: Shop? = null
    var ansPacket: List<Packet>? = null
    for (buy in shops) {
        for (sell in shops) {
            val role = buy.buy(gold, packages, sell)
//            println("--------------------------------------")
//            println("--------------------------------------")
            if (role.gold > (gold + maxProfit)) {
                maxProfit = role.gold - gold
                ansPacket = role.packets
                buyShop = buy
                sellShop = sell
            }
//            println("去${sell.name} 卖，能够获利${tempProfit}, 最终金额:${tempProfit + gold}")
//            println("--------------------------------------")
        }
    }
    ansPacket?.forEach {
        it.items.forEach { item ->
            println("在${buyShop!!.name} 买 ${item.id}")
        }
    }
    println("去${sellShop!!.name}卖，能够获利${maxProfit}, 最终金额:${maxProfit + gold}")
    return maxProfit + gold
}

fun doOnce(gold: Int, packages: List<Packet>, buy: Shop, shops: List<Shop>): Int {
    var maxProfit = 0
    var sellShop: Shop? = null
    var ansPacket: List<Packet>? = null
    for (sell in shops) {
//        val retPackets = doOnce(gold, packages, buy, sell)
        val role = buy.buy(gold, packages, sell)
//            println("--------------------------------------")
//            println("--------------------------------------")
        if (role.gold > (gold + maxProfit)) {
            maxProfit = role.gold - gold
            ansPacket = role.packets
            sellShop = sell
        }
//            println("去${sell.name} 卖，能够获利${tempProfit}, 最终金额:${tempProfit + gold}")
//            println("--------------------------------------")
    }
    if (sellShop == null) {
        println("没地方卖，${sellShop}")
        return gold
    }
    ansPacket?.forEach {
        it.items.forEach { item ->
            println("在${buy.name} 买 ${item.id}")
        }
    }
    println("去${sellShop.name} 卖，能够获利${maxProfit}, 最终金额:${maxProfit + gold}")
    return maxProfit + gold
}


data class Role(var gold: Int, val packets: List<Packet>, val flowList: ArrayList<String> = ArrayList()) {

    fun printFlow() {
        flowList.forEach {
            println(it)
        }
    }
}

class Packet(val maxWeight: Int) {
    var weight = 0
    val items = ArrayList<Item>()
    val remainWeight get() = maxWeight - weight

    fun addItem(item: Item?): Boolean {
        if (item == null) return true
        if (weight + item.weight > maxWeight) return false
        weight += item.weight
        items.add(item)
        return true
    }

    fun clear() {
        items.clear()
        weight = 0
    }

    fun removeItem(item: Item?): Boolean {
        if (item == null) return true
        return if (items.remove(item)) {
            weight -= item.weight
            true
        } else {
            false
        }
    }

    fun copy(): Packet {
        val p = Packet(maxWeight)
        items.forEach { item ->
            p.addItem(item)
        }
        return p
    }

    override fun toString(): String {
        return "Packet(maxWeight=$maxWeight, weight=$weight, items=$items, remainWeight=$remainWeight)"
    }

}

class Shop(val name: String, items: List<Item>, val prices: Map<String, Int>, val maxEntry: Int = 2) {
    // 可以进入商店的次数
    var entryCount = 0
        private set
    var itemMap = HashMap<String, Item>()

    init {
        items.forEach {
            itemMap[it.id] = it
        }
    }

    /**
     * 出售
     */
    fun sell(items: List<Item>) {

    }

    fun getPrice(item: Item): Int {
        return prices[item.id] ?: 0
    }

    fun enable(): Boolean {
        return entryCount < maxEntry
    }

    fun reduceCount() {
        entryCount--
    }

    fun sellAll(role: Role): Role {
        role.gold += sell(role.packets)
        return role
    }

    private fun sell(packets: List<Packet>): Int {
        var gold = 0
        packets.forEach {
            it.items.forEach {
                gold += getPrice(it)
            }
            it.clear()
        }
        return gold
    }

    fun buy(gold: Int, packages: List<Packet>, sell: Shop): Role {
        entryCount++
        // 单位重量 利润从高到低排列
        val orderQueue = LinkedList<Order>()
        itemMap.values.forEach {
            val sellPrice = sell.getPrice(it)
            val buyPrice = getPrice(it)
            if (sellPrice - buyPrice > 0) { // 卖出更高
                orderQueue.add(Order(it, this, sell))
            }
        }
        if (orderQueue.isEmpty()) return Role(gold, packages)
        val retPackets =
            buyUntilOverflow(gold, packages, Order(item = Item("", 0), buyShop = this, sellShop = sell), orderQueue)
        var pay = 0
        retPackets.forEach {
            it.items.forEach { item ->
                pay += getPrice(item)
            }
        }
        return Role(gold - pay, retPackets)
    }

    private fun buyUntilOverflow(
        gold: Int,
        packets: List<Packet>,
        pendingOrder: Order,
        orderQueue: List<Order>
    ): List<Packet> {
//    println("候选订单：${pendingOrder.item}, buy: ${pendingOrder.buyShop.getPrice(pendingOrder.item)}; sell: ${pendingOrder.sellShop.getPrice(pendingOrder.item)}")
//    println("当前余额：$gold")
        // 判断钱是否充足
        val remainGold = gold - pendingOrder.buyShop.getPrice(pendingOrder.item)
        if (remainGold < 0) {
//        println("钱不够，结束; ${packets}")
            val tempPacket = ArrayList<Packet>()
            packets.forEach {
                tempPacket.add(it.copy())
            }
            return tempPacket
        }
        // 判断是否有足够的空间存放
        var addedPacket: Packet? = null
        for (packet in packets) {
            if (addedPacket != null) break
            if (packet.addItem(pendingOrder.item)) {
                addedPacket = packet
                if (pendingOrder.item.id.isEmpty()) { // 去除空单
                    packet.removeItem(pendingOrder.item)
                }
            }
        }

        if (addedPacket == null) { // 没有空间
//        println("放不下，结束; ${packets}")
            val tempPacket = ArrayList<Packet>()
            packets.forEach {
                tempPacket.add(it.copy())
            }
            return tempPacket
        }
        // 计算一下当前物品的利润
        val tempPacket = ArrayList<Packet>()
        packets.forEach {
            tempPacket.add(it.copy())
        }
        var maxProfit = 0
        tempPacket.forEach {
            it.items.forEach { item ->
                maxProfit += pendingOrder.sellShop.getPrice(item) - pendingOrder.buyShop.getPrice(item)
            }
        }
        orderQueue.forEach { order ->
            val ret = buyUntilOverflow(remainGold, packets, order, orderQueue)
            var tempProfit = 0
            ret.forEach {
                it.items.forEach { item ->
                    tempProfit += pendingOrder.sellShop.getPrice(item) - pendingOrder.buyShop.getPrice(item)
                }
            }
//        println("比较一下购买方案，新方案利润:${tempProfit}, 之前利润$maxProfit")
            if (tempProfit > maxProfit) {
                maxProfit = tempProfit
                tempPacket.clear()
                tempPacket.addAll(ret)
            }
        }
        // 移除添加的
        addedPacket.removeItem(pendingOrder.item)
        return tempPacket
    }
}

data class Item(
    val id: String,
//                val price: Int,
    val weight: Int
)

data class Goods(val id: String, val price: Int, val weight: Int)

data class Order(val item: Item, val buyShop: Shop, val sellShop: Shop)

