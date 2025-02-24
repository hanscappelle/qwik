package be.hcpl.android.qwik.domain.repository

import be.hcpl.android.qwik.R
import be.hcpl.android.qwik.domain.model.Block
import be.hcpl.android.qwik.domain.model.Program
import be.hcpl.android.qwik.domain.model.RateZone
import be.hcpl.android.qwik.ui.i18n.Literals

interface ProgramRepository {

    // TODO look into generation based on time and type?
    fun getAll(): List<Program>

}

class LocalProgramRepository(
    private val literals: Literals,
) : ProgramRepository {

    override fun getAll(): List<Program> {

        return listOf(

            Program(
                title = literals.get(R.string.program_title_cadans),
                blocks = listOf(
                    Block(repeats = 1, literals.get(R.string.program_warm_up), zone = RateZone.D0, durationMin = 10),
                    Block(4, literals.get(R.string.program_cadans_high), zone = RateZone.D2, durationMin = 5),
                    Block(4, literals.get(R.string.program_cadans_low), zone = RateZone.D1, durationMin = 5),
                    Block(1, literals.get(R.string.program_cool_down), zone = RateZone.D0, durationMin = 10),
                )
            ),

            Program(
                title = literals.get(R.string.program_title_endurance),
                blocks = listOf(
                    Block(repeats = 1, literals.get(R.string.program_warm_up), zone = RateZone.D0, durationMin = 10),
                    Block(1, literals.get(R.string.program_endurance), zone = RateZone.D1, durationMin = 100),
                    Block(1, literals.get(R.string.program_cool_down), zone = RateZone.D0, durationMin = 10),
                )
            ),

            Program(
                title = literals.get(R.string.program_title_power),
                blocks = listOf(
                    Block(repeats = 1, literals.get(R.string.program_warm_up), zone = RateZone.D0, durationMin = 10),
                    Block(4, literals.get(R.string.program_low_cadans), zone = RateZone.D1, durationMin = 5),
                    Block(4, literals.get(R.string.program_stay_in_zone), zone = RateZone.D1, durationMin = 5),
                    Block(1, literals.get(R.string.program_cool_down), zone = RateZone.D0, durationMin = 10),
                )
            ),

            Program(
                title = literals.get(R.string.program_title_recovery),
                blocks = listOf(
                    Block(repeats = 1, literals.get(R.string.program_warm_up), zone = RateZone.D0, durationMin = 10),
                    Block(1, literals.get(R.string.program_stay_in_zone), zone = RateZone.D0, durationMin = 40),
                    Block(1, literals.get(R.string.program_cool_down), zone = RateZone.D0, durationMin = 10),
                )
            ),

            Program(
                title = literals.get(R.string.program_title_tempo_endurance),
                blocks = listOf(
                    Block(repeats = 1, literals.get(R.string.program_warm_up), zone = RateZone.D0, durationMin = 15),
                    Block(2, literals.get(R.string.program_stay_in_zone), zone = RateZone.D2, durationMin = 10),
                    Block(2, literals.get(R.string.program_stay_in_zone), zone = RateZone.D1, durationMin = 5),
                    Block(1, literals.get(R.string.program_cool_down), zone = RateZone.D0, durationMin = 15),
                )
            ),

            Program(
                title = literals.get(R.string.program_title_block),
                blocks = listOf(
                    Block(repeats = 1, literals.get(R.string.program_warm_up), zone = RateZone.D0, durationMin = 15),
                    Block(3, literals.get(R.string.program_stay_in_zone), zone = RateZone.D3, durationMin = 5),
                    Block(3, literals.get(R.string.program_stay_in_zone), zone = RateZone.D1, durationMin = 5),
                    Block(1, literals.get(R.string.program_cool_down), zone = RateZone.D0, durationMin = 15),
                )
            ),

            Program(
                title = literals.get(R.string.program_title_sprint),
                blocks = listOf(
                    Block(repeats = 1, literals.get(R.string.program_warm_up), zone = RateZone.D0, durationMin = 30),
                    Block(5, literals.get(R.string.program_cadans_high), zone = RateZone.D4, durationMin = 1),
                    Block(5, literals.get(R.string.program_stay_in_zone), zone = RateZone.D1, durationMin = 2),
                    Block(1, literals.get(R.string.program_cool_down), zone = RateZone.D0, durationMin = 15),
                )
            ),

            Program(
                title = literals.get(R.string.program_title_vo2max),
                blocks = listOf(
                    Block(repeats = 1, literals.get(R.string.program_warm_up), zone = RateZone.D0, durationMin = 15),
                    Block(2, literals.get(R.string.program_low_cadans), zone = RateZone.D4, durationMin = 5),
                    Block(2
                        , literals.get(R.string.program_stay_in_zone), zone = RateZone.D1, durationMin = 10),
                    Block(1, literals.get(R.string.program_cool_down), zone = RateZone.D0, durationMin = 15),
                )
            ),

        )
    }
}