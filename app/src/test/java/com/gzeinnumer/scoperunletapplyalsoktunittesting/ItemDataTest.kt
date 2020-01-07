package com.gzeinnumer.scoperunletapplyalsoktunittesting

import org.junit.Assert.*
import org.junit.Test

class ItemDataTest{
    @Test
    fun testApply(){
        val item  = ItemData(1,"Zein", "Padang")
        println("Before $item")
        item.apply {
            this.add = "Jakarta"
        }
        println("After $item")
    }

    @Test
    fun testWith(){
        val item  = ItemData(1,"Zein", "Padang")
        println("Before $item")
        with(item){
            add = "Jakarta"
        }
        println("After $item")
    }

    @Test
    fun testLet(){
        val item  = ItemData(1,"Zein", "Padang")
        val item2 : ItemData? = null

        addItem(item)

        //1
        item2?.let { addItem(it) }
        //2
        if(item2 != null){
            addItem(item2)
        }
        //1 dan 2 itu sama
    }

    private fun addItem(item: ItemData) {
        println("Nama ${item.nama}")
    }

    @Test
    fun testRun(){
        var item  = ItemData(1,"Zein", "Padang")
        println("Before $item")

        item = kotlin.run {
            val data  = ItemData(1,"Zein", "Padang")
            data
        }
        println("After $item")
    }

    @Test
    fun testAlso(){
        val item  = ItemData(1,"Zein", "Padang")

        val result = item.also {
            println("Before ${it.add}")
            it.add = "Jakarta"
        }

        println("After $item")
        println("After $result")
    }
}