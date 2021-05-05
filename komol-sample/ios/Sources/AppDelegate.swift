// swiftlint:disable discouraged_optional_collection

import Shared
import UIKit

class AppDelegate: UIResponder, UIApplicationDelegate {
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        #if DEBUG
            BootstrapKt.bootstrap(debuggable: true)
        #else
            BootstrapKt.bootstrap(debuggable: false)
        #endif

        let repo = SampleRepository()
        repo.getText { text, error in
            if let error = error {
                Komol.e(error)
                return
            }
            Komol.d("\(text!)@Swift")
        }

        return true
    }
}
