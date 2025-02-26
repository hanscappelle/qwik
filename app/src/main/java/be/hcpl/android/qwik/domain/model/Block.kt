package be.hcpl.android.qwik.domain.model

data class Block(
    val repeats: Int = 1,
    val description: String,
    val minRateBpm: Int = 0,
    val maxRateBpm: Int = 0,
    val zone: RateZone,
    val durationMin: Int,
)

