package ev.aykhn.portfolio.data.dataSource.remote

import com.google.firebase.firestore.DocumentSnapshot

interface WorkplacesRemoteDataSource {

    suspend fun getWorkplaces(): List<DocumentSnapshot>

}