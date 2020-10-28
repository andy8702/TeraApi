import 'package:flutter/material.dart';
import 'package:flutter_module/FlutterMainPage.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner:false ,
      title: '综合查询',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: FlutterMainPage(title: '综合查询'),
      routes: <String, WidgetBuilder>{
        "main_flutter": (context) => FlutterMainPage()
      },
    );
  }
}



