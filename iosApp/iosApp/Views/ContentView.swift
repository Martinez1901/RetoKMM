import SwiftUI
import domain

struct ContentView: View {
    
    typealias TabElement = (name: String, imageName: String)
    
    let screen = UIScreen.main.bounds
    let tabs = [
        TabElement("Comics", "house.fill"),
        TabElement("Characters", "bookmark.circle.fill"),
        TabElement("Search", "video.circle.fill")]
    
    @State private var selection = 0
    
    var body: some View {
        
        TabView(selection: $selection) {
            ComicsView()
                .tabItem {
                    Image(systemName: tabs[.zero].imageName)
                    Text(tabs[.zero].name)
                }
            
            CharactersView()
                .tabItem {
                    Image(systemName: tabs[1].imageName)
                    Text(tabs[1].name)
                }
            
            SearchComicView()
                .tabItem {
                    Image(systemName: tabs[2].imageName)
                    Text(tabs[2].name)
                }
        }
        .accentColor(.black)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
