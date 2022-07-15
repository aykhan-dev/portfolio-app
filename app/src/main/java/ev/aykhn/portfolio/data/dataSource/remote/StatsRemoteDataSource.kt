package ev.aykhn.portfolio.data.dataSource.remote

import com.google.firebase.firestore.DocumentSnapshot

interface StatsRemoteDataSource {

    suspend fun getStats(): List<DocumentSnapshot>

}