package upv.dadm.devalent.practicainterfaz.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import upv.dadm.devalent.practicainterfaz.data.newquotation.NewQuotationDataSource
import upv.dadm.devalent.practicainterfaz.data.newquotation.NewQuotationDataSourceImpl
import upv.dadm.devalent.practicainterfaz.data.newquotation.NewQuotationRepository
import upv.dadm.devalent.practicainterfaz.data.newquotation.NewQuotationRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class NewQuotationBinderModule {
    @Binds
    abstract fun bindNewQuotationRepository(newQuotationRepositoryImpl: NewQuotationRepositoryImpl): NewQuotationRepository
    @Binds
    abstract fun bindNewQuotationDataSource(newQuotationDataSourceImpl: NewQuotationDataSourceImpl): NewQuotationDataSource
}