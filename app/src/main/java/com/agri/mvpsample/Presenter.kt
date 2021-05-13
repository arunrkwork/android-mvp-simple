package com.agri.mvpsample

class Presenter(
    private var mainView: Contract.View?,
    private var model: Contract.Model
): Contract.Presenter, Contract.Model.OnFinishedListener {

    override fun onFinished(string: String?) {
        mainView?.let {
            it!!.setString(string)
            it!!.hideProgress()
        }
    }

    override fun onButtonClick() {
        mainView?.let {
            it!!.showProgress()
        }
        model.getNextCourse(this)
    }

    override fun onDestroy() {
        mainView = null
    }


}