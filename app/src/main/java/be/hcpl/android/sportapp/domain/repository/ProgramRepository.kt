package be.hcpl.android.sportapp.domain.repository

import be.hcpl.android.sportapp.domain.model.Block
import be.hcpl.android.sportapp.domain.model.Program
import be.hcpl.android.sportapp.domain.model.RateZone

interface ProgramRepository {

    // for now just have some hardcoded programs, TODO look into generation based on time and type?
    fun getAll(): List<Program>

}

class LocalProgramRepository() : ProgramRepository {

    override fun getAll(): List<Program> {

        // TODO translations needed here & more programs
        return listOf(

            Program(
                title = "Cadans-Training",
                blocks = listOf(
                    Block(repeats = 1, "warm up", zone = RateZone.D0, durationMin = 10),
                    Block(4, "high cadans 100-110 rpm", zone = RateZone.D2, durationMin = 5),
                    Block(4, "lower cadans", zone = RateZone.D1, durationMin = 5),
                    Block(1, "cool down", zone = RateZone.D0, durationMin = 10),
                )
            ),

            Program(
                title = "Duur-Training",
                blocks = listOf(
                    Block(repeats = 1, "warm up", zone = RateZone.D0, durationMin = 10),
                    Block(1, "volhouden", zone = RateZone.D1, durationMin = 100),
                    Block(1, "cool down", zone = RateZone.D0, durationMin = 10),
                )
            ),

            Program(
                title = "Kracht-Training",
                blocks = listOf(
                    Block(repeats = 1, "warm up", zone = RateZone.D0, durationMin = 10),
                    Block(4, "low cadans 80-90 rpm", zone = RateZone.D1, durationMin = 5),
                    Block(4, "zone", zone = RateZone.D1, durationMin = 5),
                    Block(1, "cool down", zone = RateZone.D0, durationMin = 10),
                )
            )

        )
    }
}