//
//  ComicsView.swift
//  iosApp
//
//  Created by Juan Cardona on 30/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct Comic: Identifiable {
    var id: String
    var name: String
    var imageUrl: String
    var description: String
}

let comic = Comic(id: "", name: "3-D man", imageUrl: "https://picsum.photos/200", description: "Homero simpson es una personaje asdjahdl aslkdj ")

struct ComicsView: View {
    
    let comics = [comic, comic, comic, comic, comic,comic, comic, comic, comic]
    @State var presentingModal = false

    init() {
//       UITableView.appearance().separatorStyle = .none
//       UITableViewCell.appearance().backgroundColor = .black
//       UITableView.appearance().backgroundColor = .black
    }
    
    var body: some View {
        
        let itemsCount = comics.count.isMultiple(of: 2) ? comics.count/2 : (Int(comics.count/2) + 1)
        
//        NavigationView(content: {
//
//            VStack(alignment: .center, spacing: nil, content: {
//                    List {
//
//                        ForEach(0..<itemsCount) { i in
//                            HStack {
//                                ForEach(0..<2) { j in
//                                    if i*2 + j < comics.count {
//
//                                        CollectionComicView(comic: comics[i*2 + j])
//                                            .onTapGesture {
//                                                presentingModal.toggle()
//                                            }
//                                    } else {
//                                        HStack { }
//                                            .frame(minWidth: .zero, maxWidth: .infinity, alignment: .center)
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    .listRowInsets(EdgeInsets())
//                    .listStyle(SidebarListStyle())
//            })
//            .fullScreenCover(isPresented: $presentingModal, content: {
//                DetailView()
//            })
//
//            .navigationTitle("Comics")
//            .background(Color.white)
//            NavigationLink(destination: Text("Destination")) { Text("Navigate")
//            }
//        })
        

        
        VStack(alignment: .center, spacing: nil, content: {
                List {
                    Text("Comics")
                        .fontWeight(.bold)
                        .font(.system(size: 20))
                        .frame(minWidth: .zero, maxWidth: .infinity, alignment: .leading)

                    ForEach(0..<itemsCount) { i in
                        HStack {
                            ForEach(0..<2) { j in
                                if i*2 + j < comics.count {

                                    CollectionComicView(comic: comics[i*2 + j])
                                        .onTapGesture {
                                            presentingModal.toggle()
                                        }
                                } else {
                                    HStack { }
                                        .frame(minWidth: .zero, maxWidth: .infinity, alignment: .center)
                                }
                            }
                        }
                    }
                }
                .listRowInsets(EdgeInsets())
                .listStyle(SidebarListStyle())
        })
        .fullScreenCover(isPresented: $presentingModal, content: {
            DetailView()
        })
        //.sheet(isPresented: $presentingModal) { DetailView() }

        
    }
}

struct CollectionComicView: View {
    
    let comic: Comic
    
    var body: some View {
        VStack(alignment: .center, content: {
            CustomImageView(urlString: comic.imageUrl)
                .frame(minWidth: .zero, maxWidth: .infinity, minHeight: .zero, maxHeight: .infinity, alignment: .center)
            
            Text(comic.name)
                .fontWeight(.semibold)
                .frame(minWidth: .zero, maxWidth: .infinity, alignment: .leading)
        })
        .padding(.all)

    }
    
}

struct ComicsView_Previews: PreviewProvider {
    static var previews: some View {
        ComicsView()
    }
}
