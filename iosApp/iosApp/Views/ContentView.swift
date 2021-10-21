import SwiftUI

struct ContentView: View {
    typealias TabElement = (name: String, imageName: String)
    let tabs = [
        TabElement("Comics", "house.fill"),
        TabElement("Characters", "bookmark.circle.fill"),
        TabElement("Search", "video.circle.fill")]
    
    @State private var selection = 0
    @State private var navTitle = "Comics"
     
    var body: some View {
        NavigationView {
            TabView(selection: $selection) {
                ComicsView()
                    .tabItem {
                        Image(systemName: tabs[.zero].imageName)
                        Text(tabs[.zero].name)
                    }
                    .foregroundColor(Color("colorPrimary"))
                    .tag(0)
                
                CharactersView()
                    .tabItem {
                        Image(systemName: tabs[1].imageName)
                        Text(tabs[1].name)
                    }
                    .tag(1)
                
                SearchView()
                    .tabItem {
                        Image(systemName: tabs[2].imageName)
                        Text(tabs[2].name)
                    }
                    .tag(2)
                
            }
            .accentColor(Color("colorPrimary"))
            .onChange(of: selection){ _ in
                getNavTitlte(selection: selection){ title in
                    navTitle = title
                }
            }
            .navigationTitle(navTitle)
        } .navigationViewStyle(.stack)
            .accentColor(Color("colorPrimary"))
        
    }
    
    func getNavTitlte(selection: Int,res:(String)-> Void ) {
        var title = ""
        switch(selection){
        case 0 :
            title = "Comics"
        case 1 :
            title = "Characters"
        default :
            title = "Search"
        }
        res(title)
    }
}
