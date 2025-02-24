package be.hcpl.android.qwik.domain.model

data class Program(
    val title: String,
    val blocks: List<Block>,
)

data class Block(
    val repeats: Int = 1,
    val description: String,
    val minRateBpm: Int = 0,
    val maxRateBpm: Int = 0,
    val zone: RateZone,
    val durationMin: Int,
)

enum class RateZone{
    D0, D1, D2, D3, D4
}