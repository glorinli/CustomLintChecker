package xyz.glorin.customlint.checker

import com.android.tools.lint.client.api.IssueRegistry
import xyz.glorin.customlint.checker.detectors.AndroidLogDetector

class CustomRegistry : IssueRegistry() {
    override val issues = listOf(
        AndroidLogDetector.ISSUE
    )
}