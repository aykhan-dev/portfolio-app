package ev.aykhn.portfolio.data.mapper

import com.google.firebase.firestore.DocumentSnapshot
import ev.aykhn.portfolio.R
import ev.aykhn.portfolio.domain.uiModel.SkillUI

object SkillMapper {

    fun toSkillUIs(rawData: List<DocumentSnapshot>): List<SkillUI> {
        return rawData.map { snapshot ->
            SkillUI(
                iconResId = R.drawable.ic_hashtag,
                title = snapshot["name"].toString(),
                description = snapshot["description"].toString(),
            )
        }
    }

}