import QtQuick 2.15
import QtQuick.Window 2.15
import QtQuick.Layouts 1.12
Window {
    width: 640
    height: 480
    visible: true
    title: qsTr("ColumnLayout")
    property int myMargin:10 // Устанавливаем отступы
    minimumWidth:cl.implicitWidth+2*myMargin // Минимальная ширина окна
    ColumnLayout{
        id:cl
        spacing: myMargin
        anchors.fill:parent // Иначе не увидим выравнивание
        Comp{
            id: head
            tex: "Header"
            Layout.fillWidth: true
            Layout.minimumWidth:400
        }
        Rectangle{
            id: main
            Layout.fillHeight: true
            Layout.fillWidth: true
            property alias tex: t.text
            Text{
                id: t
                text:"Main"
                anchors.centerIn: main
                font.pixelSize: 24
            }

        } // Подпираем снизу содержимое
        Comp{
            tex: ""
            Layout.fillWidth: true
            Layout.minimumWidth:400
            color: "white"
            RowLayout{
                width: parent.width
                spacing:10
                Comp{
                    id: p1
                    opacity:1
                    tex: "1"
                    Layout.fillWidth: true
                    MouseArea {
                        anchors.fill: parent
                        onClicked: {p1.opacity=1;p2.opacity=0.5;
                        p3.opacity=0.5;head.tex = "Header1";main.tex = "1 Item content";}
                    }
                }
                Comp{
                    id: p2
                    tex: "2"
                    Layout.fillWidth: true
                    MouseArea {
                        anchors.fill: parent
                        onClicked: {p2.opacity=1;p1.opacity=0.5;
                        p3.opacity=0.5;head.tex = "Header2";main.tex = "2 Item content";}
                    }
                }
                Comp{
                    id: p3
                    tex: "3"
                    Layout.fillWidth: true
                    MouseArea {
                        anchors.fill: parent
                        onClicked: {p3.opacity=1;p1.opacity=0.5;
                        p2.opacity=0.5;head.tex = "Header3";main.tex = "3 Item content";}
                    }
                }
            }


        }
    }
}
