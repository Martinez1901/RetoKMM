
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

struct Title:View {
    let title : String
    var body: some View {
        Text(title)
            .fontWeight(.bold)
            .font(.system(size: 20))
            .frame(minWidth: .zero, maxWidth: .infinity, alignment: .leading)
    }
}
