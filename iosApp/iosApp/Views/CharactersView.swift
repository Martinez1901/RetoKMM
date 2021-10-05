//
//  CreatorsView.swift
//  iosApp
//
//  Created by Juan Cardona on 30/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI


struct CharactersView: View {
    
    var body: some View {
        
        List { 
            Text("Characters")
                .fontWeight(.bold)
                .font(.system(size: 20))
                .frame(minWidth: .zero, maxWidth: .infinity, alignment: .leading)
            
            ForEach(0..<10) { i in
                CharacterView()
            }
        }
        .listStyle(SidebarListStyle())

    }
}

struct CharacterView: View {
    var body: some View {
        HStack(alignment: .center, spacing: 20, content: {
            CustomImageView(urlString: comic.imageUrl)
                .frame(minWidth: .zero, maxWidth: 80, minHeight: .zero, maxHeight: .infinity, alignment: .center)
                .clipShape(Circle())
            Text(comic.name)
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
