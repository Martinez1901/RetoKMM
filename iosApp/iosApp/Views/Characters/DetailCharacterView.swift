import SwiftUI
import shared

struct DetailCharacterView: View {
    let character : CharacterShared
    
    var body: some View {
        ScrollView {
            VStack(spacing: 0) {
                CustomImageView(urlString: character.thumbnailPath)
                
                Text(character.name)
                    .font(.title)
                    .bold()
                    .padding()
                    .frame(minWidth: .zero, maxWidth: .infinity, minHeight: .zero, maxHeight: .infinity)
                    .background(Color.black)
                    .foregroundColor(.white)
                
                Text("Description")
                    .font(.headline)
                    .frame(minWidth: .zero, maxWidth: .infinity, alignment: .leading)
                    .padding(.top)
                    .padding(.leading)
                Text(!character.description.isEmpty ? character.description : "Description not found")
                    .font(.body)
                    .padding()
            }
        }
        .edgesIgnoringSafeArea(.top)
    }
} 
