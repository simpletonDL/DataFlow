package ru.itmo.mse.dataflow.datagen.collector

import ru.itmo.mse.dataflow.lang.ast.Program

interface Collector {
    fun collect(): Set<Tuple>
}

interface CollectorFabric {
    fun createCollector(program: Program): Collector
}
