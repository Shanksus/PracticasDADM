package upv.dadm.devalent.practicainterfaz.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import upv.dadm.devalent.practicainterfaz.data.newquotation.NewQuotationRepositoryImpl
import upv.dadm.devalent.practicainterfaz.data.newquotation.NewQuotationRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class NewQuotationBinderModule {

    @Binds
    abstract fun bindNewQuotationRepository(repository: NewQuotationRepositoryImpl) : NewQuotationRepository
}