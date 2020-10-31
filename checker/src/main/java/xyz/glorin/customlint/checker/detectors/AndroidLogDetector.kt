package xyz.glorin.customlint.checker.detectors

import com.android.tools.lint.detector.api.*
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression

class AndroidLogDetector : Detector(), SourceCodeScanner {
    override fun getApplicableMethodNames(): List<String>? {
        return listOf("wtf", "v", "d", "i", "w", "e")
    }

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        if (context.evaluator.isMemberInClass(method, "android.util.Log")) {
            context.report(ISSUE, context.getLocation(node), "Don't use Android log directly")
        }
    }

    companion object {
        val ISSUE = Issue.create(
            "AndroidLogDeprecated",
            "Please don't use android log directly, use Timber instead",
            "Please don't use android log directly, use Timber instead",
            Category.LINT,
            5,
            Severity.WARNING,
            Implementation(AndroidLogDetector::class.java, Scope.JAVA_FILE_SCOPE)
        )
    }
}