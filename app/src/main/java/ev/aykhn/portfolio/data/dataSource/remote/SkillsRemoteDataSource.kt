package ev.aykhn.portfolio.data.dataSource.remote

import com.google.firebase.firestore.DocumentSnapshot

interface SkillsRemoteDataSource {

    suspend fun loadHardSkills(): List<DocumentSnapshot>

    suspend fun loadSoftSkills(): List<DocumentSnapshot>

}