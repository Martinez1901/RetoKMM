import SwiftUI
import shared

struct CharactersView: View {
    private let viewModel = CharactersListViewModel()
    @State var characters = [CharacterShared]()
    var body: some View {
        List {
            Text("Characters")
                .fontWeight(.bold)
                .font(.system(size: 20))
                .frame(minWidth: .zero, maxWidth: .infinity, alignment: .leading)
            
            if(!characters.isEmpty){
                ForEach(characters, id: \.self) { item in
                    CharacterView(data: item)
                }
            }
        }
        .listStyle(SidebarListStyle())
        .onAppear {
            viewModel.characters.addObserver{ (data) in
                guard let res = data else { return }
                switch res.status {
                case  Status.success :
                    if let list = res.data {
                        characters = list as! [CharacterShared]
                        //                           let number : Int = Int.random(in: 0...characters.count-1)
                        //                           let character = characters[number] as! CharacterShared
                        //                           name = character.name
                    }
                case  Status.loading :
                    print("loading")
                case  Status.error :
                    print("error")
                default:
                    print("default")
                }
            }
            viewModel.getInformation(updateData: true)
        }
        
    }
}

struct CharacterView: View {
    let data: CharacterShared
    var body: some View {
        HStack(alignment: .center, spacing: 20, content: {
            CustomImageView(urlString: data.thumbnailPath)
                .frame(minWidth: .zero, maxWidth: 80, minHeight: .zero, maxHeight: .infinity, alignment: .center)
                .clipShape(Circle())
            Text(data.name)
                .fontWeight(.semibold)
                .font(.system(size: 20))
                .frame(minWidth: .zero, maxWidth: .infinity, alignment: .leading)
        })
            .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: 80, alignment: .center)
    }
}

struct CharactersView_Previews: PreviewProvider {
    static var previews: some View {
        CharactersView()
    }
}
