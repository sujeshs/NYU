package edu.nyu.sdg.penalties.model

import java.math.BigDecimal
import java.util.*

data class AcrisEntry (
  // DO NOT sort this
  var bBL10Digits: String?,
  var documentId: String?,
  var documentType: String?,
  var documentAmount: BigDecimal?,
  var documentRecordedTimestamp: Date?,
  var partyType: String?,
  var name: String?,
  var address1: String?,
  var zipCode: String?,
  var iteration: Int?,
)
