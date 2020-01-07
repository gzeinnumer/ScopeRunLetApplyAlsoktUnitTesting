package com.gzeinnumer.scoperunletapplyalsoktunittesting

import org.junit.Assert.*
import org.junit.Test

class ItemDataTest{

    @Test //harus dipastikan tidak null -> use this -> mereturn data(bisa diletakan di variable)
    fun testRun(){
        var item  = ItemData(1,"Zein", "Padang")
        println("Before $item")

        item = kotlin.run {
            val data  = ItemData(1,"Zein", "Padang")
            data
        }
        println("After $item")
    }

    @Test //same with "with" -> use this -> tidak bisa mereturn data(tidak bsa diletakan di variable)
    fun testApply(){
        val item  = ItemData(1,"Zein", "Padang")
        println("Before $item")
        item.apply {
            add = "Jakarta"
        }
        println("After $item")
    }

    @Test // harus dipastikan tidak ada kemungkinan data null
    fun testWith(){
        val item  = ItemData(1,"Zein", "Padang")
        println("Before $item")
        with(item){
            add = "Jakarta"
        }
        println("After $item")
    }

    @Test //ada kemungkinan data null // pengecekan null
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

    @Test //bisa ditampung di variable, -> pass IT -> tidak mereturn data -> sama dengan let
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