package ru.itmo.mse.dataflow.datagen.collector

class Tuple(val relName: String, vararg attr: Any) {
    val attrs: MutableList<String> = attr.map { it.toString() }.toMutableList()

    fun addAttr(attr: Any) {
        attrs.add(attr.toString())
    }

    override fun toString() = "$relName(${attrs.joinToString()})"
}