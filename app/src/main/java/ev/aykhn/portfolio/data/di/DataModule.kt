package ev.aykhn.portfolio.data.di

import ev.aykhn.portfolio.data.dataSource.remote.SkillsRemoteDataSource
import ev.aykhn.portfolio.data.dataSource.remote.StatsRemoteDataSource
import ev.aykhn.portfolio.data.dataSource.remote.WorkplacesRemoteDataSource
import ev.aykhn.portfolio.data.dataSourceImpl.remote.SkillsRemoteDataSourceImpl
import ev.aykhn.portfolio.data.dataSourceImpl.remote.StatsRemoteDataSourceImpl
import ev.aykhn.portfolio.data.dataSourceImpl.remote.WorkplacesRemoteDataSourceImpl
import ev.aykhn.portfolio.data.repositoryImpl.SkillsRepositoryImpl
import ev.aykhn.portfolio.data.repositoryImpl.StatsRepositoryImpl
import ev.aykhn.portfolio.data.repositoryImpl.WorkplacesRepositoryImpl
import ev.aykhn.portfolio.domain.repository.SkillsRepository
import ev.aykhn.portfolio.domain.repository.StatsRepository
import ev.aykhn.portfolio.domain.repository.WorkplacesRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {

    singleOf(::WorkplacesRepositoryImpl) { bind<WorkplacesRepository>() }
    singleOf(::SkillsRepositoryImpl) { bind<SkillsRepository>() }
    singleOf(::StatsRepositoryImpl) { bind<StatsRepository>() }

    singleOf(::WorkplacesRemoteDataSourceImpl) { bind<WorkplacesRemoteDataSource>() }
    singleOf(::SkillsRemoteDataSourceImpl) { bind<SkillsRemoteDataSource>() }
    singleOf(::StatsRemoteDataSourceImpl) { bind<StatsRemoteDataSource>() }

}