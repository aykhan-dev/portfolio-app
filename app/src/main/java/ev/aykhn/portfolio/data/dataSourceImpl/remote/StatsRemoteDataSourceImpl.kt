package ev.aykhn.portfolio.data.dataSourceImpl.remote

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import ev.aykhn.portfolio.data.dataSource.remote.StatsRemoteDataSource
import kotlinx.coroutines.tasks.await

class StatsRemoteDataSourceImpl: StatsRemoteDataSource {

    private val db = Firebase.firestore

    override suspend fun getStats(): List<DocumentSnapshot> {
        val subscription = db.collection("stats").get().await()
        return subscription.documents
    }

}