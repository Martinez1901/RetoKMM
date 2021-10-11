import SwiftUI
import shared

struct ContentView: View {
    private let viewModel = CharactersListViewModel()
    @State var name = ""
    var body: some View {
        Text(name)
            .onAppear {
                viewModel.characters.addObserver{ (data) in
                       guard let res = data else { return }
                       switch res.status {
                       case  Status.success :
                           if let characters = res.data {
                               let number : Int = Int.random(in: 0...characters.count-1)
                               let character :CharacterView = characters[number] as! CharacterView
                               name = character.name
                           }
                       case  Status.loading :
                           print("loading")
                       case  Status.error :
                           print("error")
                       default:
                           print("default")
                       }
                }
                viewModel.getInformation()
            }
    }
 
    
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
