import SwiftUI
import domain

struct ContentView: View {
    let test = Test().getData()

	var body: some View {
		Text(test)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView()
	}
}
