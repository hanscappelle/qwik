package be.hcpl.android.sportapp.domain.repository

import be.hcpl.android.sportapp.R
import be.hcpl.android.sportapp.domain.model.Block
import be.hcpl.android.sportapp.domain.model.Program
import be.hcpl.android.sportapp.domain.model.RateZone
import be.hcpl.android.sportapp.ui.i18n.Literals

interface ProgramRepository {

    // for now just have some hardcoded programs, TODO look into generation based on time and type?
    fun getAll(): List<Program>

}

class LocalProgramRepository(
    private val literals: Literals,
) : ProgramRepository {

    override fun getAll(): List<Program> {

        return listOf(

            Program(
                title = literals.get(R.string.program_cadans_title),
                blocks = listOf(
                    Block(repeats = 1, literals.get(R.string.program_warm_up), zone = RateZone.D0, durationMin = 10),
                    Block(4, literals.get(R.string.program_cadans_high), zone = RateZone.D2, durationMin = 5),
                    Block(4, literals.get(R.string.program_cadans_low), zone = RateZone.D1, durationMin = 5),
                    Block(1, literals.get(R.string.program_cool_down), zone = RateZone.D0, durationMin = 10),
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