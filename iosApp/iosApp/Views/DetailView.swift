//
//  DetailView.swift
//  iosApp
//
//  Created by Juan Cardona on 1/10/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct DetailView: View {
    private let imageHeight: CGFloat = 300
    @State private var pickerSelection = 0

    var body: some View {
 
        ScrollView {

            VStack {
                Image("comicHeader")
                    .resizable()
                    .scaledToFill()
                    .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, idealHeight: imageHeight, maxHeight: imageHeight)
                    .clipped()
                Picker("Details", selection: $pickerSelection) {
                                Text("Details").tag(0)
                                Text("Characters").tag(1)
                                Text("Creator").tag(2)
                            }
                .pickerStyle(SegmentedPickerStyle())
                .padding(EdgeInsets.init(top: 0, leading: 16, bottom: 2, trailing: 16))
                
                let _ = print(pickerSelection)
                if pickerSelection == 0 {
                    Text("0")
                } else if pickerSelection == 1 {
                    Text("1")
                } else {
                    Text("2")
                }
            }
            .offset(y: 0)
        }.edgesIgnoringSafeArea(.all)
    }
}

struct DetailView_Previews: PreviewProvider {
    static var previews: some View {
        DetailView()
    }
}

//                Text("Nombre personaje")
//                    .fontWeight(.bold)
//                    .font(.system(size: 30))
//                    .frame(minWidth: .zero, maxWidth: .infinity, alignment: .leading)
//                    .padding(EdgeInsets.init(top: 16, leading: 16, bottom: 2, trailing: 16))
//                Text("Subtitulo")
//                    .fontWeight(.semibold)
//                    .font(.system(size: 20))
//                    .frame(minWidth: .zero, maxWidth: .infinity, alignment: .leading)
//                    .padding(EdgeInsets.init(top: 0, leading: 16, bottom: 0, trailing: 16))
//
//                Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
//                    .fontWeight(.regular)
//                    .font(.system(size: 14))
//                    .frame(minWidth: .zero, maxWidth: .infinity, alignment: .leading)
//                    .padding()
