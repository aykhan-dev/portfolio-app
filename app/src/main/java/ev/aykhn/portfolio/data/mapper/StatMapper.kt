package ev.aykhn.portfolio.data.mapper

import com.google.firebase.firestore.DocumentSnapshot
import ev.aykhn.portfolio.domain.uiModel.StatUI

object StatMapper {

    fun toStatUIs(rawData: List<DocumentSnapshot>): List<StatUI> {
        return rawData.map { snapshot ->
            StatUI(
                indicator = snapshot["indicator"].toString(),
                description = snapshot["description"].toString(),
            )
        }
    }

}