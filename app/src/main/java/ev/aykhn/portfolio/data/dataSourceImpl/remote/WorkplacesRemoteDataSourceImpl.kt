package ev.aykhn.portfolio.data.dataSourceImpl.remote

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import ev.aykhn.portfolio.data.dataSource.remote.WorkplacesRemoteDataSource
import ev.aykhn.portfolio.domain.uiModel.WorkplaceUI
import kotlinx.coroutines.tasks.await

class WorkplacesRemoteDataSourceImpl: WorkplacesRemoteDataSource {

    private val db = Firebase.firestore

    override suspend fun getWorkplaces(): List<DocumentSnapshot> {
        val subscription = db.collection("workplaces").get().await()
        return subscription.documents
    }

}