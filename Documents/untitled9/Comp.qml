import QtQuick

import QtQuick 2.0
Rectangle{
    property alias tex: t.text
    id:rect1
    width:150
    height: 100
    border.width: 1
    color: "gray"
    Text{
        id: t
        text:"My color: "+rect1.color
        anchors.centerIn: rect1
        font.pixelSize: 24
    }
}
