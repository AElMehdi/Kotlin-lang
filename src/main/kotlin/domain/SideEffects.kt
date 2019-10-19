package domain


data class SideEffects(var section: String = "Effets Indésirables",
                       var granularity: String = "Section",
                       var sideEffects: List<SideEffect>)

data class SideEffect(var header : String, var sideEffects : List<String>)
