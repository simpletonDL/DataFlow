package ru.itmo.mse.dataflow.datagen.collector

class Tuple(val relName: String, vararg attr: Any) {
    val attrs: List<String> = attr.map { it.toString() }

    override fun toString() = "$relName(${attrs.joinToString()})"
}