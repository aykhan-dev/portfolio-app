package ev.aykhn.portfolio.data.mapper

import com.google.firebase.firestore.DocumentSnapshot
import ev.aykhn.portfolio.R
import ev.aykhn.portfolio.domain.uiModel.SkillUI
import ev.aykhn.portfolio.domain.uiModel.WorkplaceUI

object WorkplaceMapper {

    fun toWorkplaceUIs(rawData: List<DocumentSnapshot>): List<WorkplaceUI> {
        return rawData.map { snapshot ->
            WorkplaceUI(
                name = snapshot["name"].toString(),
                role = snapshot["role"].toString(),
                websiteLink = "",
            )
        }
    }

}