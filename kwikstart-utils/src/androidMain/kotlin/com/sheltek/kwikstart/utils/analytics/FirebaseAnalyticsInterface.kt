package com.sheltek.kwikstart.utils.analytics

import android.os.Bundle
import com.google.android.gms.tasks.Task
import com.google.firebase.analytics.FirebaseAnalytics
import com.sheltek.kwikstart.core.analytics.AnalyticsInterface

interface FirebaseAnalyticsInterface : AnalyticsInterface {
    val sessionId: Task<Long?>
    val firebaseInstanceId: String
    val appInstanceId: Task<String?>
    fun resetAnalyticsData()
    fun setDefaultEventParams(params: Bundle?)
    fun setFirebaseConsent(consentMap: Map<FirebaseAnalytics.ConsentType, FirebaseAnalytics.ConsentStatus>)
    fun setAnalyticsCollectionEnabled(enabled: Boolean)
    fun setUserId(id: String)
}
