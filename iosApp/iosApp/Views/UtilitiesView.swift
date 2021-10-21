
import SwiftUI
import shared

struct ProgressViewCustom: View {
    var body: some View {
        ProgressView()
            .progressViewStyle(CircularProgressViewStyle(tint: .blue))
            .scaleEffect(3)
            .padding(10)
            .frame(minWidth: .zero, maxWidth: .infinity)
    }
}

struct TextEmptyView:View {
    var body: some View {
        Text("Empty List")
            .fontWeight(.bold)
            .font(.system(size: 15))
            .padding(30)
            .frame(minWidth: .zero, maxWidth: .infinity,minHeight: .zero,maxHeight: .infinity)
    }
}

struct TextFielSearch : View {
    @Binding var searchText : String
    @Binding var msgToast : String
    @Binding var showToast : Bool
    let action:()->Void
    var body: some View {
        TextField("Search",text: $searchText)
            .padding(.bottom)
        Button(action: { 
            if (searchText.isEmpty) {
                msgToast = "Enter the name of a comic."
                showToast.toggle()
            } else {
                action()
            }
        }){
           Text("Search")
                .padding()
                .frame(minWidth: .zero, maxWidth: .infinity, minHeight: .zero, maxHeight: 40)
                .background(Color.black)
                .foregroundColor(.white).cornerRadius(10)
        }
    }
}
