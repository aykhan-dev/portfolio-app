package ev.aykhn.portfolio.data.dataSourceImpl.remote

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import ev.aykhn.portfolio.data.dataSource.remote.SkillsRemoteDataSource
import kotlinx.coroutines.tasks.await
import timber.log.Timber

class SkillsRemoteDataSourceImpl : SkillsRemoteDataSource {

    private val db = Firebase.firestore

    override suspend fun loadHardSkills(): List<DocumentSnapshot> {
        val subscription = db.collection("skills").get().await()
        return subscription.documents.filter { it["type"] == "HARD" }
    }

    override suspend fun loadSoftSkills(): List<DocumentSnapshot> {
        val subscription = db.collection("skills").get().await()
        return subscription.documents.filter { it["type"] == "SOFT" }
    }

}