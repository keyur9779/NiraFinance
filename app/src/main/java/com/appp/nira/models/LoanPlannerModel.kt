package com.appp.nira.models

data class LoanPlannerModel(
    var defaultLoanAmount: Int = 20000,
    val loanUpperLimit: Int = 100000,
    val loanLowerLimit: Int = 5000,
    val loanMover: Int = 1000,
    val tenureMin: Int = 3,
    val tenureMax: Int = 12,
    val tenurMover: Int = 1,
    var tenurDefault: Int = 9,
    val interest: Int = 2,
    var amount:Int = 0,
    var keyur:String = "asdasdsad"

)
