import SwiftUI
import shared

struct ContentView: View {
    
    let viewModel = ViewModelTest()
    
	var body: some View {
        Text(viewModel.getData())
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView()
	}
}