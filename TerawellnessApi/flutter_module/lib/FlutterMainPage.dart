import 'package:flutter/material.dart';

class FlutterMainPage extends StatelessWidget {
  final String title;

  FlutterMainPage({Key key, this.title}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text(this.title),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Text(
                "请从左侧滑出菜单",
                style: TextStyle(
                    fontSize: 40.0,
                    fontWeight: FontWeight.bold,
                    color: Colors.red),
              ),
              Text(
                '''
              说明：
              1.教练查询:查询一个教练全部的排课
              
              2.单课查询:查询当天某一课程的全部排课
              
              3.会所查询:查询某个会所的单日排课
              ''',
                style: TextStyle(
                    fontSize: 20.0,
                    fontWeight: FontWeight.normal,
                    color: Colors.blueAccent),
              )
            ],
          ),
        ),
        drawer: Drawer(
            child: Column(
          children: <Widget>[
            UserAccountsDrawerHeader(
              accountName: Text("Andy"),
              accountEmail: Text("seababy_8702@163.com"),
              currentAccountPicture: CircleAvatar(
                backgroundImage:
                    NetworkImage("https://www.itying.com/images/flutter/3.png"),
              ),
              decoration: BoxDecoration(
                  color: Colors.yellow,
                  image: DecorationImage(
                      image: NetworkImage(
                          "https://www.itying.com/images/flutter/2.png"),
                      fit: BoxFit.cover)),
            ),
            ListTile(
              title: Text("教练查询"),
              leading: CircleAvatar(child: Icon(Icons.people)),
            ),
            Divider(),
            ListTile(
              title: Text("单课查询"),
              leading: CircleAvatar(child: Icon(Icons.golf_course)),
            ),
            Divider(),
            ListTile(
              title: Text("会所查询"),
              leading: CircleAvatar(child: Icon(Icons.location_city)),
            )
          ],
        )));
  }
}
