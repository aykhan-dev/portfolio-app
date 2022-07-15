package ev.aykhn.portfolio.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ev.aykhn.portfolio.R
import ev.aykhn.portfolio.domain.uiModel.SkillUI
import ev.aykhn.portfolio.presentation.ui.theme.*

enum class SkillCardType {
    Flat, Colored
}

@Composable
fun SkillCard(
    skill: SkillUI,
    modifier: Modifier = Modifier,
    skillCardType: SkillCardType = SkillCardType.Flat,
) {
    val cardBackgroundColor =
        if (skillCardType == SkillCardType.Flat) Color.Transparent else Vulcan2

    val iconBackground = if (skillCardType == SkillCardType.Flat) Vulcan2 else Primary4
    val iconTint = if (skillCardType == SkillCardType.Flat) White1 else Vulcan1

    Card(
        shape = MaterialTheme.shapes.medium,
        backgroundColor = cardBackgroundColor,
        elevation = 0.dp,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingMedium),
        ) {
            Image(
                painter = painterResource(id = skill.iconResId),
                contentDescription = "",
                colorFilter = ColorFilter.tint(color = iconTint),
                modifier = Modifier
                    .size(44.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(iconBackground),
                contentScale = ContentScale.Inside
            )
            Text(
                text = skill.title,
                style = MaterialTheme.typography.body1Bold,
                modifier = Modifier.padding(top = paddingLarge),
            )
            Text(
                text = skill.description,
                style = MaterialTheme.typography.body2.copy(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier.padding(top = paddingNormal),
            )
        }
    }
}

@Preview
@Composable
fun SkillCardPreview() {
    PortfolioTheme {
        SkillCard(
            skill = SkillUI(
                R.drawable.ic_hashtag,
                "UI/UX Design",
                "The time that leads to mastery is dependent on the intensity of our focus."
            ),
            skillCardType = SkillCardType.Colored,
        )
    }
}