package com.gof.composite;

/**
 * 抽象组件
 * @author Administrator
 *
 */
public interface Component {

	void operation();
}

/**
 * 叶子组件
 * @author Administrator
 *
 */
interface leaf extends Component{
	
}

interface Composite extends Component{
	void add(Component component);
	void remove(Component component);
	Component getChild(int index);
}
 
