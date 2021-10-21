import SwiftUI
import shared

struct CharacterListView: View {
    @Binding var isLoading : Bool
    @Binding var characters: [CharacterShared]
    
    var body: some View {
        if isLoading {
            ProgressViewCustom()
                .padding(.top,50)
        }else{
            if(!characters.isEmpty){
                LazyVStack(){
                    ForEach(characters, id: \.self) { character in
                        NavigationLink(destination: DetailCharacterView(character: character)){
                            CharacterItemView(data: character)
                        }.buttonStyle(PlainButtonStyle())
                    }
                }.padding()
            }else{
                TextEmptyView()
                    .padding()
            }
        }
    }
}
