//
//  SearchView.swift
//  iosApp
//
//  Created by Juan Cardona on 1/10/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct SearchView: View { 
    
    var body: some View {
        VStack() {
            NavigationLink(destination: SearchComicsView()){
                SearchItem(image: "banner_comics", name: "Comics")
            }.buttonStyle(PlainButtonStyle())
            
            NavigationLink(destination: SearchCharactersView()){
                SearchItem(image: "marvel_heroes", name: "Characters")
            }.buttonStyle(PlainButtonStyle())
            
            Spacer()
        }.padding()
    }
}

struct SearchItem: View {
    let image: String
    let name: String
    var body: some View {
        VStack(alignment: .center, spacing: 10 ) {
            Image(image)
                .resizable()
                .cornerRadius(5)
                .frame(minWidth: .zero, maxWidth: .infinity, minHeight: .zero, maxHeight: 150)
            Text(name)
                .fontWeight(.semibold)
                .font(.system(size: 20))
                .frame(minWidth: .zero, maxWidth: .infinity, alignment: .leading)
        }
    }
} 
