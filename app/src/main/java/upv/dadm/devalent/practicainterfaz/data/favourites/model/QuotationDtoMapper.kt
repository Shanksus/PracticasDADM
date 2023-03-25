package upv.dadm.devalent.practicainterfaz.data.favourites.model

import upv.dadm.devalent.practicainterfaz.domain.model.Quotation

fun QuotationDto.toDomain(): Quotation = Quotation(id = id, cita = text, autor = author)

fun Quotation.toDto(): QuotationDto = QuotationDto(id = id, text = cita, author = autor)
