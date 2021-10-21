import SwiftUI
import shared

struct CharacterItemView: View {
    let data: CharacterShared
    var body: some View {
        HStack(alignment: .center, spacing: 20, content: {
            CustomImageView(urlString: data.thumbnailPath)
                .frame(width: 80, height: 80)
                .clipShape(Circle())
                .overlay(Circle().stroke(Color.gray,lineWidth:1/2))
                .shadow(radius: 5)
            Text(data.name)
                .fontWeight(.semibold)
                .font(.system(size: 20))
                .frame(minWidth: .zero, maxWidth: .infinity, alignment: .leading)
        })
    }
}
